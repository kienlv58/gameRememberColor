package AdapterCustom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kien.game_gridview_remembercolor.R;

import java.util.ArrayList;

import Enity.PointEnity;

/**
 * Created by Kiên on 12/31/2015.
 */
public class AdapterPoint extends BaseAdapter{
    ArrayList<PointEnity> Arr_listData;
    LayoutInflater inflater;
    @Override
    public int getCount() {
        return Arr_listData.size();
    }

    public AdapterPoint(ArrayList<PointEnity> arr_listData, Context context) {
        Arr_listData = arr_listData;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<PointEnity> getArr_listData() {
        return Arr_listData;
    }

    public void setArr_listData(ArrayList<PointEnity> arr_listData) {
        Arr_listData = arr_listData;
    }

    @Override
    public PointEnity getItem(int position) {
        return Arr_listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PointEnity p = getItem(position);
        TextView txt_point;
        if (convertView == null)
            convertView = inflater.inflate(R.layout.point_layout,null);
        txt_point = (TextView)convertView.findViewById(R.id.txt_point);
        txt_point.setBackgroundColor(Color.argb(p.getColor_last().getAnpha(),p.getColor_last().getRed(),
                p.getColor_last().getGreen(),p.getColor_last().getBlue()));
        txt_point.setText(p.getText());
        return convertView;
    }
}
