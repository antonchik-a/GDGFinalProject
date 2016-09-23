package ru.gdgkazan.footbalproject.utils;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

import ru.gdgkazan.footbalproject.R;

/**
 * Created by Sergei Riabov
 */
public final class Images {

    private static final int IMAGE_SIZE = 250;
    private static final String SVG_FORMAT = "svg";

    private Images() {
    }

    public static void loadTeamLogo(@NonNull ImageView imageView, @NonNull String stringUrl, boolean isPreview) {
        if(isImageTypeSvg(stringUrl)) {
            loadSvgImage(imageView, stringUrl, isPreview);
        } else {
            loadPngImage(imageView,stringUrl,isPreview);
        }
    }

    public static void loadCountryFlag(@NonNull ImageView imageView, @NonNull String code) {
        String url = "http://www.geonames.org/flags/x/" + code.toLowerCase() + ".gif";
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.country_na)
                .into(imageView);
    }

    private static void loadSvgImage(@NonNull ImageView imageView, @NonNull String stringUrl, boolean isPreview) {
        Uri url = Uri.parse(stringUrl);
        GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> builder = Glide.with(imageView.getContext())
                .using(Glide.buildStreamModelLoader(Uri.class, imageView.getContext()), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .listener(new SvgSoftwareLayerSetter<>())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE);

        if(isPreview) {
            builder.override(IMAGE_SIZE,IMAGE_SIZE);
        }
        builder
                .load(url)
                .error(R.drawable.icon_standings_default_team_logo)
                .into(imageView);
    }

    private static void loadPngImage(@NonNull ImageView imageView, @NonNull String stringUrl, boolean isPreview) {
        DrawableRequestBuilder builder = Glide.with(imageView.getContext())
                .load(stringUrl);

        if(isPreview) {
            builder.override(IMAGE_SIZE, IMAGE_SIZE);
        }

        builder
                .error(R.drawable.icon_standings_default_team_logo)
                .into(imageView);
    }

    private static boolean isImageTypeSvg(String stringUrl){
        String[] urlSplit = stringUrl.split("\\.");
        String format;
        try{
            format = urlSplit[urlSplit.length - 1];
            return format.equals(SVG_FORMAT);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
