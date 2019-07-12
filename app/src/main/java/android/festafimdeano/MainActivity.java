package android.festafimdeano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLefts = findViewById(R.id.text_label_days_left);
        this.mViewHolder.btnConfirm = findViewById(R.id.btn_confirmar);

        //Adicionar um evento quando o botão for pressionado
        this.mViewHolder.btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    private static class ViewHolder{
        TextView textToday;
        TextView textDaysLefts;
        Button btnConfirm;
    }
}
