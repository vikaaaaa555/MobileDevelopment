//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mobiledevelopment.R
//
//class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
//
//    private var historyList = mutableListOf<String>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val historyItem = historyList[position]
//        holder.bind(historyItem)
//    }
//
//    override fun getItemCount(): Int {
//        return historyList.size
//    }
//
//    fun setItems(items: List<String>) {
//        historyList.clear()
//        historyList.addAll(items)
//        notifyDataSetChanged()
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val titleTextView: TextView = itemView.findViewById(R.id.item_title)
//
//        fun bind(historyItem: String) {
//            titleTextView.text = historyItem
//        }
//    }
//}
