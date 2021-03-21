package hr.vsite.map.sofascoreaa_zad1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import hr.vsite.map.sofascoreaa_zad1.databinding.EditTextStringBinding

class EditStringText(context: Context, attributeSet: AttributeSet): FrameLayout (context,attributeSet){

    val binding: EditTextStringBinding

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.edit_text_string, null, false)
        binding = EditTextStringBinding.bind(view)
        addView(binding.root)
        context.theme.obtainStyledAttributes(attributeSet,R.styleable.EditStringText,0,0).apply {
            try {
                binding.tvFirstName.text = getString(R.styleable.EditStringText_textViewText)
                binding.etFirstName.hint = getString(R.styleable.EditStringText_editTextHint)
            } finally {
                recycle()
            }
        }
    }

    fun getCurrentText(): String {
        return binding.etFirstName.text.toString()
    }

    fun reset(){
        binding.etFirstName.text.clear()
    }
}