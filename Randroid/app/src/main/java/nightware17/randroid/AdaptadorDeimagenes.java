package nightware17.randroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by drm_6 on 2016-04-12.
 */
public class AdaptadorDeimagenes extends BaseAdapter {

        private Context context;

    public AdaptadorDeimagenes(Context context) {
        this.context = context;
    }

    @Override
        public int getCount() {
            return image.ITEMS.length;
        }

        @Override
        public image getItem(int position) {
            return image.ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.grid_item, parent, false);
            }

            ImageView imagen = (ImageView) view.findViewById(R.id.imagen);
            TextView nombre = (TextView) view.findViewById(R.id.nombre);

            final image item = getItem(position);
            imagen.setImageResource(item.getIdDrawable());
            nombre.setText(item.getNombre());

            return view;
        }

}
