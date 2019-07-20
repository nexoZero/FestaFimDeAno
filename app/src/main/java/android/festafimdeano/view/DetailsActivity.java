package android.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.festafimdeano.R;
import android.festafimdeano.constant.FimdeAnoConstant;
import android.festafimdeano.data.SecurityPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipacao = findViewById(R.id.check_participacao);
        this.mSecurityPreferences = new SecurityPreferences(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.check_participacao){
            if(this.mViewHolder.checkParticipacao.isChecked()){
                //Salvar presença
                this.mSecurityPreferences.storePreferences(FimdeAnoConstant.PRENSENCE_KEY, FimdeAnoConstant.PRENSENCE_YES);
            } else {
                //Salvar ausencia
                this.mSecurityPreferences.storePreferences(FimdeAnoConstant.PRENSENCE_KEY, FimdeAnoConstant.PRENSENCE_NO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipacao;
    }

}
