package cn.com.gmcc.sign.fragment

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.com.gmcc.sign.*
import cn.com.gmcc.sign.db.pojo.MissionEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_mission.*
import kotlinx.android.synthetic.main.item_mission.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.apache.commons.io.IOUtils
import org.jetbrains.anko.*
import java.io.IOException
import java.text.SimpleDateFormat


class MissionFragment : Fragment() {
    lateinit var application: MyApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(view.context, layoutManager.orientation))
        val adapter = MissionAdapter()
        recyclerView.adapter = adapter
        application = activity?.application as MyApplication

        application.database.missionDao().missions().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }


}

class MissionViewHolder(val view: View) : RecyclerView.ViewHolder(view)
class MissionAdapter(var list: List<MissionEntity> = listOf()) : RecyclerView.Adapter<MissionViewHolder>() {
    private val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mission, parent, false)
        return MissionViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        val mission = list[position]
        holder.view.titleTv.text = mission.name
        holder.view.siteTv.text = mission.url

        holder.view.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("mission", mission)
            it.findNavController().navigate(R.id.action_missionFragment_to_readFragment, bundle)


        }
    }

}
