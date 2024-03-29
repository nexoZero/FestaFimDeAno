package android.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.festafimdeano.R;
import android.festafimdeano.constant.FimdeAnoConstant;
import android.festafimdeano.data.SecurityPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    //Formata a data em DIA/MES/ANO
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLefts = findViewById(R.id.text_label_days_left);
        this.mViewHolder.btnConfirm = findViewById(R.id.btn_confirmar);

        //Adicionar um evento quando o botão for pressionado
        this.mViewHolder.btnConfirm.setOnClickListener(this);

        //Definer a data do dia atual
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String dayLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.days));
        this.mViewHolder.textDaysLefts.setText(dayLeft);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_confirmar) {
            String presence = this.mSecurityPreferences.getStorePreferences(FimdeAnoConstant.PRENSENCE_KEY);
            //Abrir a nova activity
            Intent intent = new Intent(this, android.festafimdeano.view.DetailsActivity.class);
            intent.putExtra(FimdeAnoConstant.PRENSENCE_KEY, presence);
            startActivity(intent);
        }
    }

    private int getDaysLeft(){
        //Pega a data de hoje
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        //Pega o numero maximo de dias do ano
        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayMax-today;
    }

    private void verifyPresence(){
        //resgata o valor salvo para check_participacao
        String presence = this.mSecurityPreferences.getStorePreferences(FimdeAnoConstant.PRENSENCE_KEY);
            if(presence.equals("")){
                this.mViewHolder.btnConfirm.setText(R.string.nao_confirmado);
            } else if(presence.equals(FimdeAnoConstant.PRENSENCE_YES)){
                this.mViewHolder.btnConfirm.setText(R.string.sim);
            } else {
                this.mViewHolder.btnConfirm.setText(R.string.nao);
            }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLefts;
        Button btnConfirm;
    }
}
