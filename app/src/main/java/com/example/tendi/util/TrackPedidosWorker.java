package com.example.tendi.util;

import com.example.tendi.general.AsistenteFragment;
import com.example.tendi.general.Pedidos;
import com.example.tendi.model.Pedido;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class TrackPedidosWorker extends Thread {

    private Boolean isAlive;
    private ArrayList<Pedido> pedidoArray;
    private AsistenteFragment ref;

    public TrackPedidosWorker(AsistenteFragment ref) {
        this.ref = ref;
        this.isAlive = true;
        this.pedidoArray = new ArrayList<>();
    }

    @Override
    public void run() {
        HTTPSWebUtilDomi https = new HTTPSWebUtilDomi();
        Gson gson = new Gson();
        while (isAlive){
            delay(3000);
            String json = https.GETrequest(Constants.BASEURL+"pedidos.json");
                Type type = new TypeToken< HashMap<String, Pedido> >(){}.getType();
                HashMap<String, Pedido> pedidos = gson.fromJson(json, type);
            pedidoArray.clear();

            if(pedidos != null){
                pedidos.forEach((key,value)->{
                    Pedido p = new Pedido();
                    pedidoArray.add(p);
                });
                //ref.(pedidoArray);
            }

        }
    }

    public void delay (long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finish(){
        this.isAlive = false;
    }
}
