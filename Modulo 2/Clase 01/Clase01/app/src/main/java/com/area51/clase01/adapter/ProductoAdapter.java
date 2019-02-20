package com.area51.clase01.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.clase01.R;
import com.area51.clase01.modelos.Marca;
import com.area51.clase01.modelos.Producto;
import com.area51.clase01.sqlite.MetodoSQLite;

import java.util.ArrayList;

public class ProductoAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Producto> lista = null;
    private Context context;

    public ProductoAdapter(ArrayList<Producto> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    class ProductoViewHolder extends
            RecyclerView.ViewHolder {

        AppCompatTextView tvNombre, tvMarca, tvModelo, tvColor;
        CardView contenedor;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = (AppCompatTextView) itemView.findViewById(R.id.tvNombre);
            tvMarca = (AppCompatTextView) itemView.findViewById(R.id.tvMarca);
            tvModelo = (AppCompatTextView) itemView.findViewById(R.id.tvModelo);
            tvColor = (AppCompatTextView) itemView.findViewById(R.id.tvColor);
            contenedor = (CardView) itemView.findViewById(R.id.contenedor);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_producto, viewGroup, false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int posicion) {
        final Producto producto = lista.get(posicion);

        ProductoViewHolder holder = (ProductoViewHolder) viewHolder;
        holder.tvNombre.setText(producto.getNombre());
        holder.tvMarca.setText(producto.getMarca());
        holder.tvModelo.setText(producto.getModelo());
        holder.tvColor.setText(producto.getColor());

        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(context);
                builder.setTitle("Opciones");
                builder.setMessage("Seleccione una opción");
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cargarDialog(producto);
                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eliminar(posicion, producto);
                    }
                });
                builder.show();

            }
        });
    }

    private void cargarDialog(Producto producto) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.item_modificar);
        dialog.getWindow().setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        AppCompatSpinner spMarca = (AppCompatSpinner) dialog.findViewById(R.id.spMarca);
        AppCompatEditText etModelo = (AppCompatEditText) dialog.findViewById(R.id.etModelo);
        AppCompatEditText etColor = (AppCompatEditText) dialog.findViewById(R.id.etColor);
        AppCompatEditText etNombre = (AppCompatEditText) dialog.findViewById(R.id.etNombre);
        AppCompatButton btnModificar = (AppCompatButton) dialog.findViewById(R.id.btnModificar);

        MetodoSQLite sqLite = new MetodoSQLite(context);
        ArrayList<Marca> listaMarca = sqLite.obtenerMarcas();
        ArrayList<String> marcaTexto = new ArrayList<>();
        marcaTexto.add("Seleccione");
        for (Marca item : listaMarca) {
            marcaTexto.add(item.getId() + " - " + item.getNombre());
        }
        ArrayAdapter adapter = new ArrayAdapter(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                marcaTexto
        );
        spMarca.setAdapter(adapter);

        etModelo.setText(producto.getModelo());
        etNombre.setText(producto.getNombre());
        etColor.setText(producto.getColor());

        for (int i = 0; i < listaMarca.size(); i++) {
            Marca item = listaMarca.get(i);
            if (item.getNombre().equals(producto.getMarca())) {
                spMarca.setSelection(i + 1);
                break;
            }
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dialog.show();
    }

    private void eliminar(int posicion, Producto producto) {
        MetodoSQLite sqLite = new MetodoSQLite(context);
        int result = sqLite.eliminarProductoPorId(producto.getId());
        if (result == 1) {
            lista.remove(producto);
            notifyDataSetChanged();
            Toast.makeText(context, "Se elimino", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "No se elimino", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
