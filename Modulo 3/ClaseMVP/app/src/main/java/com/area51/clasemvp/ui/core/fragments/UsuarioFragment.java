package com.area51.clasemvp.ui.core.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.area51.clasemvp.R;
import com.area51.clasemvp.ui.core.adapters.UsuarioAdapter;
import com.area51.clasemvp.ui.core.presenter.UsuarioPresenter;
import com.area51.clasemvp.ui.core.presenter.impl.UsuarioPresenterImpl;
import com.area51.clasemvp.ui.core.views.UsuarioView;
import com.area51.clasemvp.ui.model.Usuario;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioFragment extends Fragment implements UsuarioView {
    private UsuarioPresenter presenter;
    private View view;
    private RecyclerView rvDatos;

    public UsuarioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new UsuarioPresenterImpl();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (presenter != null)
            presenter.removeView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_usuario, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.addView(this);
        presenter.initViews();

    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.cargarDatos();
    }

    @Override
    public void init() {
        rvDatos = view.findViewById(R.id.rvDatos);
    }

    @Override
    public void onError(String mensaje) {
        Toast.makeText(getContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(ArrayList<Usuario> convert) {
        UsuarioAdapter adapter = new UsuarioAdapter(convert, getContext());
        rvDatos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDatos.setAdapter(adapter);
    }
}
