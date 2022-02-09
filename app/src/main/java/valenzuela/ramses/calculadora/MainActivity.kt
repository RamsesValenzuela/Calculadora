package valenzuela.ramses.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tv1: TextView
    lateinit var tv2: TextView
    var contador: Double = 0.0
    var oper: Int = 0
    var num1: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.tv_uno)
        tv2 = findViewById(R.id.tv_Dos)

        var btnBorrar: Button = findViewById(R.id.btnBorrar)
        var btnRes: Button = findViewById(R.id.btnResult)




        btnRes.setOnClickListener {
            var resp: Double = 0.0
            var numero2: Double = 0.0
            if (tv2.text.toString() == "") {
                tv2.setText("0.0")
            } else {
                numero2 = tv2.text.toString().toDouble()

                when (oper) {
                    1 -> resp = num1 + numero2
                    2 -> resp = num1 - numero2
                    3 -> resp = num1 * numero2
                    4 -> resp = num1 / numero2

                }

                if (oper == 4 && numero2 == 0.0) {
                    tv2.setText("No se puede una division entre 0")
                } else {
                    tv2.setText(resp.toString())
                    tv1.setText("")

                }
            }
        }

        btnBorrar.setOnClickListener{
            tv1.setText("")
            tv2.setText("")
            num1 = 0.0

        }
    }

    fun digitos(view: View){

        var num2: String = tv2.text.toString()

        when(view.id){
            R.id.btn0 -> tv2.setText(num2 + "0")
            R.id.btn1 -> tv2.setText(num2 + "1")
            R.id.btn2 -> tv2.setText(num2 + "2")
            R.id.btn3 -> tv2.setText(num2 + "3")
            R.id.btn4 -> tv2.setText(num2 + "4")
            R.id.btn5 -> tv2.setText(num2 + "5")
            R.id.btn6 -> tv2.setText(num2 + "6")
            R.id.btn7 -> tv2.setText(num2 + "7")
            R.id.btn8 -> tv2.setText(num2 + "8")
            R.id.btn9 -> tv2.setText(num2 + "9")
        }



    }

    fun operacion(view: View){
        num1 = tv2.text.toString().toDouble()
        var num1_text : String = tv2.text.toString()
        tv2.setText("")
        when(view.id){
            R.id.btnMas ->{
                tv1.setText(num1_text + "+")
                oper = 1
            }
            R.id.btnMenos ->{
                tv1.setText(num1_text + "-")
                oper = 2
            }
            R.id.btnMulti ->{
                tv1.setText(num1_text + "*")
                oper = 3
            }
            R.id.btnDiv ->{
                tv1.setText(num1_text + "/")
                oper = 4
            }
        }
    }

}