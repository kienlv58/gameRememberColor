package AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kien.game_gridview_remembercolor.R;

import java.util.ArrayList;

import Enity.InforHightScore;

/**
 * Created by Kiên on 1/1/2016.
 */
public class AdapterHighScore extends BaseAdapter {
    ArrayList<InforHightScore> listdata;
    LayoutInflater inflater;
    TextView txtv_hightsocre;

    public AdapterHighScore(ArrayList<InforHightScore> listdata, Context context) {
        this.listdata = listdata;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public AdapterHighScore() {

    }

    public ArrayList<InforHightScore> getListdata() {
        return listdata;
    }

    public void setListdata(ArrayList<InforHightScore> listdata) {
        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public InforHightScore getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InforHightScore data = getItem(position);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_hightscore, null);
        txtv_hightsocre = (TextView) convertView.findViewById(R.id.txtv_infor);
        txtv_hightsocre.setText((position + 1) +"."+ data.toString());
        return convertView;
    }
}
