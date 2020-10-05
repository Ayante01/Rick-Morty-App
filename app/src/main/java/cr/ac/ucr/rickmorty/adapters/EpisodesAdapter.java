package cr.ac.ucr.rickmorty.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cr.ac.ucr.rickmorty.R;
import cr.ac.ucr.rickmorty.models.Episode;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Episode> episodes;

    public EpisodesAdapter(Context context, ArrayList<Episode> episodes) {
        this.context = context;
        this.episodes = episodes;
    }

    public EpisodesAdapter(Context context) {
        this.context = context;
        this.episodes = new ArrayList<>();
    }

    @NonNull
    @Override
    public EpisodesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_episode, parent, false);
        return new EpisodesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodesAdapter.ViewHolder holder, int position) {

        Episode episode = episodes.get(position);

        holder.tvName.setText(episode.getName());
        holder.tvAirDate.setText(episode.getAirDate());
        holder.tvEpisodeNum.setText(episode.getEpisode());
    }

    @Override
    public int getItemCount() {
        return episodes != null ? episodes.size() : 0;
    }

    public void addEpisode(ArrayList<Episode> episodes) {
        this.episodes.addAll(episodes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvEpisodeCard;

        private final TextView tvName;
        private final TextView tvAirDate;
        private final TextView tvEpisodeNum;


        public ViewHolder(@NonNull View view) {
            super(view);

            cvEpisodeCard = view.findViewById(R.id.cv_episode_card);

            tvName = view.findViewById(R.id.tv_name);
            tvAirDate = view.findViewById(R.id.tv_air_date);
            tvEpisodeNum = view.findViewById(R.id.tv_episode);
        }
    }
}