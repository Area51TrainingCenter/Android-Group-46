package com.area51.clase01


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.area51.clase01.db.MetodoSQLImpl
import kotlinx.android.synthetic.main.fragment_listar.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ListarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onResume() {
        super.onResume()

        val sql = MetodoSQLImpl()
        val lista = sql.listar()

        for (item in lista) {
            val linear = LinearLayout(context)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linear.orientation = LinearLayout.HORIZONTAL
            linear.layoutParams = params

            val paramsText = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            paramsText.weight = 1f

            val textView1 = TextView(context)
            textView1.layoutParams = paramsText
            textView1.text = item.usuario
            linear.addView(textView1)

            val textView2 = TextView(context)
            textView2.layoutParams = paramsText
            textView2.text = "${item.nombre} ${item.apellido}"
            linear.addView(textView2)

            contenedorLista.addView(linear)
        }
    }

}
