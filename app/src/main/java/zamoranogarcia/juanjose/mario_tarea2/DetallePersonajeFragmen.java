package zamoranogarcia.juanjose.mario_tarea2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import zamoranogarcia.juanjose.mario_tarea2.databinding.FragmentDetallePersonajeBinding;

public class DetallePersonajeFragmen extends Fragment {

    private FragmentDetallePersonajeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetallePersonajeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener los argumentos
        if (getArguments() != null) {
            String nombre = getArguments().getString("nombre");
            int imagen = getArguments().getInt("imagen");
            String descripcion = getArguments().getString("descripcion");
            String habilidades = getArguments().getString("habilidades");

            // Configurar los elementos de la vista
            binding.textViewNombreDetalle.setText(nombre);
            binding.imageViewDetallePersonaje.setImageResource(imagen);
            binding.textViewDescripcion.setText(descripcion);
            binding.textViewHabilidades.setText(habilidades);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}