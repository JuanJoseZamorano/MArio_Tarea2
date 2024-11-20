package zamoranogarcia.juanjose.mario_tarea2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    private Context context;
    private List<Personaje> personajeList;
    private OnItemClickListener listener;

    public PersonajeAdapter(Context context, List<Personaje> personajeList, OnItemClickListener listener) {
        this.context = context;
        this.personajeList = personajeList;
        this.listener = listener;
    }


    @Override
    public PersonajeViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PersonajeViewHolder holder, int position) {
        Personaje personaje = personajeList.get(position);
        holder.textViewNombre.setText(personaje.getNombre());
        holder.imageViewPersonaje.setImageResource(personaje.getImagen());

        // Evento de clic para cada elemento
        holder.itemView.setOnClickListener(v -> listener.onItemClick(personaje));
    }

    @Override
    public int getItemCount() {
        return personajeList.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPersonaje;
        TextView textViewNombre;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            imageViewPersonaje = itemView.findViewById(R.id.imageViewPersonaje);
            textViewNombre = itemView.findViewById(R.id.textViewNombrePersonaje);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Personaje personaje);
    }
}