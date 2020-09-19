package br.com.creative.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.txtResult);
    }

    public void onButtonClick(View view){
        Button button = (Button) view;

        String textButton = button.getText().toString();
        switch (getButtonTextId(textButton)){
            case R.string.btn_clean:
                result.setText("");
                break;
            case R.string.btn_equal:
                CharSequence expression = result.getText();
                if(expression != null)
                    result.setText(calculate(expression.toString()));
                break;
            default:
                result.setText(result.getText() + textButton);
        }
    }

    private String calculate(String stringExpression){
        Expression expression = new Expression(stringExpression.replace(getString(R.string.btn_multiply),"*"));
        return BigDecimal.valueOf(expression.calculate()).toString();
    }

    private int getButtonTextId(CharSequence text){
        Map<CharSequence,Integer> texts = new HashMap<>();

        texts.put(getString(R.string.btn_zero),R.string.btn_zero);
        texts.put(getString(R.string.btn_dot),R.string.btn_dot);
        texts.put(getString(R.string.btn_equal),R.string.btn_equal);
        texts.put(getString(R.string.btn_plus),R.string.btn_plus);
        texts.put(getString(R.string.btn_one),R.string.btn_one);
        texts.put(getString(R.string.btn_two),R.string.btn_two);
        texts.put(getString(R.string.btn_three),R.string.btn_three);
        texts.put(getString(R.string.btn_minus),R.string.btn_minus);
        texts.put(getString(R.string.btn_four),R.string.btn_four);
        texts.put(getString(R.string.btn_five),R.string.btn_five);
        texts.put(getString(R.string.btn_six),R.string.btn_six);
        texts.put(getString(R.string.btn_multiply),R.string.btn_multiply);
        texts.put(getString(R.string.btn_seven),R.string.btn_seven);
        texts.put(getString(R.string.btn_eight),R.string.btn_eight);
        texts.put(getString(R.string.btn_nine),R.string.btn_nine);
        texts.put(getString(R.string.btn_divide),R.string.btn_divide);
        texts.put(getString(R.string.btn_clean),R.string.btn_clean);

        return texts.get(text);
    }

}