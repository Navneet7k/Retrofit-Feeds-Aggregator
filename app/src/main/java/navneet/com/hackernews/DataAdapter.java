package navneet.com.hackernews;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private ArrayList<AndroidVersion> websites;
    private ArrayList<AndroidVersion> articles;
    private Context context;


  /*  public DataAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
    }
    */
 /*   public DataAdapter(ArrayList<AndroidVersion> websites,Context context) {
        this.context=context;
        this.websites=websites;}
*/
    public DataAdapter(ArrayList<AndroidVersion> articles,Context context) {
        this.context=context;
        this.articles=articles;}

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, final int i) {



        viewHolder.tv_name.setText(articles.get(i).getTitle());
        final String name=articles.get(i).getTitle();
        final String author=articles.get(i).getAuthor();
        final String image=articles.get(i).getUrlToImage();
        final String date=articles.get(i).getPublishedAt();
       final String desc=articles.get(i).getDescription();
        final String more=articles.get(i).getUrl();
     /*    final String experience=websites.get(i).getExperience();

*/
        viewHolder.tv_version.setText(articles.get(i).getPublishedAt());
        Picasso.with(context).load(articles.get(i).getUrlToImage()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
               intent.putExtra(DetailsActivity.EXTRA_POST_KEY, name);
                intent.putExtra(DetailsActivity.EXTRA_DESC, desc);
                intent.putExtra(DetailsActivity.EXTRA_EXP, date);
                intent.putExtra(DetailsActivity.EXTRA_IM, image);
                intent.putExtra(DetailsActivity.EXTRA_AUTHOR, author);
                intent.putExtra(DetailsActivity.EXTRA_URL, more);
                context.startActivity(intent);

            }
        });
     //   viewHolder.tv_api_level.setText(android.get(i).getApi());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;


        private ImageView img;
        public ViewHolder(View view) {
            super(view);
            img=(ImageView)view.findViewById(R.id.img);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
       //     tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }

}