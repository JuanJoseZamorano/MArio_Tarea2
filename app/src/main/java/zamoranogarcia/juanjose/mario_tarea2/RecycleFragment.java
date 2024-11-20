package zamoranogarcia.juanjose.mario_tarea2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zamoranogarcia.juanjose.mario_tarea2.databinding.FragmentRecycleBinding;


public class RecycleFragment extends Fragment implements PersonajeAdapter.OnItemClickListener {
    private FragmentRecycleBinding binding;
    private PersonajeAdapter adapter;
    private List<Personaje> personajeList;
    public RecycleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflar el layout usando ViewBinding
        binding = FragmentRecycleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar el RecyclerView
        binding.recyclerViewPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Inicializar lista de personajes
        personajeList = new ArrayList<>();
        personajeList.add(new Personaje("Mario", R.drawable.mario, requireContext().getString(R.string.descripcionMario), requireContext().getString(R.string.habilidadesMario)));
        personajeList.add(new Personaje("Luigi", R.drawable.luigui, requireContext().getString(R.string.descripcionLuigi), requireContext().getString(R.string.habilidadesLuigi)));
        personajeList.add(new Personaje("Peach", R.drawable.peach, requireContext().getString(R.string.descripcionPeach), requireContext().getString(R.string.habilidadesPeach)));
        personajeList.add(new Personaje("Toad", R.drawable.toad, requireContext().getString(R.string.descripcionToad), requireContext().getString(R.string.habilidadesToad)));

        // Configurar el adapter
        adapter = new PersonajeAdapter(getContext(), personajeList, this);
        binding.recyclerViewPersonajes.setAdapter(adapter);
    }
    @Override
    public void onItemClick(Personaje personaje) {
        // Mostrar un Toast con el personaje seleccionado
        Toast.makeText(getContext(), getString(R.string.selecciontoast) +" "+ personaje.getNombre(), Toast.LENGTH_SHORT).show();

        // Aquí puedes implementar la navegación al fragmento de detalles usando NavController
        Bundle args = new Bundle();
        args.putString("nombre", personaje.getNombre());
        args.putInt("imagen", personaje.getImagen());
        args.putString("descripcion", personaje.getDescripcion());
        args.putString("habilidades", personaje.getHabilidades());

        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_recycleFragment_to_detallePersonajeFragmen, args);
    }

}