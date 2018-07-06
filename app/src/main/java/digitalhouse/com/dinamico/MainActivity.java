package digitalhouse.com.dinamico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button botao;
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button);

        //Pega o FragmentManager
        fragmentManager = getSupportFragmentManager();


        //Abre uma transição e adiciona
        fragmentManager.beginTransaction().add(R.id.frame1, new Fragment1()).commit();

        fragmentManager.beginTransaction().add(R.id.frame2, new Fragment2()).commit();

        //Substitui um Fragment
        //fragmentManager.beginTransaction().replace(R.id.frame1, new Fragment2()).commit();


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame2);
                if (fragment != null)
                    fragmentManager.beginTransaction().remove(fragment).commit();
                    Toast.makeText(v.getContext(), "você esta no fragment 2", Toast.LENGTH_LONG).show();


            }
        });
    }
}
