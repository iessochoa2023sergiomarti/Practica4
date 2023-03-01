package net.iessochoa.sergiomarti.p4ejemplo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.iessochoa.sergiomarti.p4ejemplo1.databinding.FragmentCambiaNombreBinding
import net.iessochoa.sergiomarti.p4ejemplo1.databinding.FragmentHiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CambiaNombreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CambiaNombreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentCambiaNombreBinding? = null
    // Definimos los argumentos que recibe el fragment
    val args: CambiaNombreFragmentArgs by navArgs()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_hi, container, false)
        _binding = FragmentCambiaNombreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Recuperamos el argumento
        binding.etCambiaNombre.setText(args.nombre)
        // Llamada a HiFragment
        binding.btCambiaNombre.setOnClickListener {
//            findNavController().navigate(R.id.action_cambiaNombreFragment_to_hiFragment)
            // Buscamos el nombre
            val nombre = binding.etCambiaNombre.text.toString()
            // Creamos la acción pasándole el valor como argumento
            val action = CambiaNombreFragmentDirections.actionCambiaNombreFragmentToHiFragment(nombre)
            // Abrimos CambiaNombreFragment
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CambiaNombreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CambiaNombreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}