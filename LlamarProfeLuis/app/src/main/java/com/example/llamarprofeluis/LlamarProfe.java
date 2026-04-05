package com.example.llamarprofeluis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class LlamarProfe extends BroadcastReceiver {
    private String TAG = "Desboqueo";
    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {


            Toast.makeText(context,"Pantalla desbloqueada detectada", Toast.LENGTH_LONG).show();


            Log.d(TAG, "Evento de desbloqueo de pantalla detectado (ACTION_USER_PRESENT).");


            //    Se usa ACTION_DIAL (y no ACTION_CALL) para no requerir
            //    el permiso, Abre el marcador sin iniciar la llamada.
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:2664553747"));

            // FLAG_ACTIVITY_NEW_TASK es obligatorio cuando se lanza
            // una Activity desde un contexto que no es una Activity
            callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(callIntent);
        }
    }
}
