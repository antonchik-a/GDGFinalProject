package ru.gdgkazan.footbalproject.utils;

        import android.graphics.drawable.PictureDrawable;
        import android.net.Uri;
        import android.support.annotation.NonNull;
        import android.util.Log;
        import android.widget.ImageView;

        import com.bumptech.glide.Glide;
        import com.bumptech.glide.load.engine.DiskCacheStrategy;
        import com.bumptech.glide.load.model.StreamEncoder;
        import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
        import com.caverock.androidsvg.SVG;

        import java.io.InputStream;

        import ru.gdgkazan.footbalproject.R;
        import ru.gdgkazan.footbalproject.model.content.Team;

/**
 * Created by Sergei Riabov
 */
public final class Images {

    private Images() {
    }

    public static void loadTeamLogo(@NonNull ImageView imageView, @NonNull Team team) {
        Uri url = Uri.parse(team.getCrestUrl());
        Glide.with(imageView.getContext())
                .using(Glide.buildStreamModelLoader(Uri.class, imageView.getContext()), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .listener(new SvgSoftwareLayerSetter<>())
                //.diskCacheStrategy(DiskCacheStrategy.NONE)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .load(url)
                .into(imageView);
    }

    public static void loadCountryFlag(@NonNull ImageView imageView, @NonNull String code) {
        String url = "http://www.geonames.org/flags/x/" + code.toLowerCase() + ".gif";
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.country_na)
                .into(imageView);
    }
}
