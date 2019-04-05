package com.area51.claseserviciopost;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternetService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            if (info.isConnected()) {
                //Recorremos la base de datos
                //Enviamos cada registro al web service

                final UsuarioInterfaz sql = new UsuarioImpl();
                RealmResults<UsuarioEntity> lista = sql.listar();
                for (final UsuarioEntity item : lista) {
                    MetodoWS metodoWS = Configuracion
                            .obtenerConfiguracion().create(MetodoWS.class);
                    Call<UsuarioResponse> call = metodoWS.registrarUsuario(
                            item.getCodpersona(),
                            item.getTipodoc(),
                            item.getNumdoc(),
                            item.getPass(),
                            item.getPrinombre(),
                            item.getSegnombre(),
                            item.getApepaterno(),
                            item.getApematerno(),
                            item.getFlgsexo(),
                            item.getFecnaci(),
                            item.getTelfijo(),
                            item.getTelcel(),
                            item.getEmailprin(),
                            item.getDesdire(),
                            item.getFlgpubli(),
                            item.getMaqip(),
                            item.getOpcion(),
                            item.getOrigen()
                    );
                    call.enqueue(new Callback<UsuarioResponse>() {
                        @Override
                        public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                            UsuarioResponse respuesta = response.body();
                            sql.eliminarPorId(item.getId());
                        }

                        @Override
                        public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                        }
                    });
                }

            } else {
                //No hay internet
            }
        }
        return START_STICKY;
    }
}
