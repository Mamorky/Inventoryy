package com.example.usuario.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by mamorky on 9/10/17.
 */

public class DashBoardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_suport);

        gridDashboard = (GridLayout) findViewById(R.id.gridDashBoard);

        int[] imgs = {R.drawable.chair,
                R.drawable.closet,
                R.drawable.cpu,
                R.drawable.inventory,
                R.drawable.keyboard,
                R.drawable.monitor,
                R.drawable.mouse,
                R.drawable.printer,
                R.drawable.proyector,
                R.drawable.table,
                R.drawable.whiteboard};

        // No se utiliza en java arrays de objetos. Se utilizan Vectores o Colleciones
        // ImageView[] imageViews = new ImageView[images.length];

        // No utilizamos la clase vector por que no trabajamos con hilos y no se requiere sincronización
        // Vector<ImageView> vectorImagesView = new Vector<ImageView>();

        /*ArrayList arrayImageViews = new ArrayList();

        for (int i = 0;i<images.length;i++){
            arrayImageViews.add(new ImageView(DashBoardActivity.this));
            if(arrayImageViews.get(i) instanceof ImageView)
                ((ImageView)arrayImageViews.get(i)).setImageResource();
        }*/

        listenerDashboard = new ClickListenerDashboard();

        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashBoardWidth);
        float height = getResources().getDimension(R.dimen.imgDashBoardHeight);

        ArrayList<ImageView> arrayImageViews = new ArrayList<ImageView>();

        for (int i = 0;i<imgs.length;i++){
            imageView = new ImageView(this);
            imageView.setImageResource(imgs[i]);
            imageView.setId(imgs[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width=(int)width;
            params.height=(int)height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashboard);
            gridDashboard.addView(imageView);
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.drawable.inventory:
                    intent = new Intent(DashBoardActivity.this,InventoryActivity.class);
                    break;
                case R.drawable.monitor:
                    intent = new Intent(DashBoardActivity.this,ConstraintActivity.class);
                    break;
                default:
                    break;
            }

            try{
                startActivity(intent);
            }
            catch (Exception e){

            }
        }
    }
}
