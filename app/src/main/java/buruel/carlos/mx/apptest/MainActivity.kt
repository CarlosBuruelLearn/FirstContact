package buruel.carlos.mx.apptest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Cursos(val nombre: String, val url: String)

class MainActivity : Activity()
{
	val react = Cursos("C++", "c_plus_plus")
	val kotlin = Cursos("Kotlin", "kotlin")
	var cursoActual = react.copy()

	var tvMensaje : TextView? = null
	var btnBoton : Button? = null

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		tvMensaje = findViewById(R.id.mensaje)
		btnBoton = findViewById(R.id.boton)

		btnBoton?.setOnClickListener{
			_ -> switchCurso(cursoActual)
		}
		btnBoton?.text = todosLosCursos()
	}

	fun switchCurso(curso :  Cursos)
	{
		when( curso.url )
		{
			"c_plus_plus" -> cursoActual = kotlin.copy()
			"kotlin" -> cursoActual = react.copy()
			else -> print("Esto nunva va a pasar")
		}

		verEnPantall("Curso de ${cursoActual.nombre} en trucoteca.com/${cursoActual.url}")
	}

	fun verEnPantall(s : String)
	{
		tvMensaje?.text = s
	}

	fun todosLosCursos() : String = "${react.nombre} y ${kotlin.nombre}"
}