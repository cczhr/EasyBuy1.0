package com.app.cczhr.easybuy;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    static int rCode1=1;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

       CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        //views.setTextViewText(R.id.appwidget_text, widgetText);
        views.setImageViewResource(R.id.zhi1, R.drawable.zhifubao);
        views.setImageViewResource(R.id.zhi2, R.drawable.zhifubao);
        views.setImageViewResource(R.id.wei1, R.drawable.weixin);
        views.setImageViewResource(R.id.wei2, R.drawable.weixin);
        views.setTextViewText(R.id.textView,"便捷买买买");
        views.setTextColor(R.id.textView, Color.BLACK);
        views.setTextViewText(R.id.t1,"扫一扫");
        views.setTextColor(R.id.t1, Color.BLACK);
        views.setTextViewText(R.id.t2,"收付款");
        views.setTextColor(R.id.t2,Color.BLACK);
        views.setTextViewText(R.id.t3,"扫一扫");
        views.setTextColor(R.id.t3,Color.BLACK);
        views.setTextViewText(R.id.t4,"收付款");
        views.setTextColor(R.id.t4, Color.BLACK);
        Intent zhi1=new Intent();
        zhi1.setData(Uri.parse("alipayqr://platformapi/startapp?saId=10000007"));
        PendingIntent zhiP1 = PendingIntent.getActivity(context,MainActivity.requestCode++, zhi1, PendingIntent.FLAG_CANCEL_CURRENT);
        Intent zhi2=new Intent();
        zhi2.setData(Uri.parse("alipays://platformapi/startapp?appId=20000056"));
        PendingIntent zhiP2 = PendingIntent.getActivity(context, MainActivity.requestCode++, zhi2, PendingIntent.FLAG_CANCEL_CURRENT);
        Intent wei1=new Intent(context,MyReceiver.class);
        Intent wei2=new Intent(context,MyReceiver.class);
        wei1.putExtra("weixin","wei1");
        PendingIntent weiP2 = PendingIntent.getBroadcast(context,MainActivity.requestCode++,  wei1, PendingIntent.FLAG_CANCEL_CURRENT);
        wei2.putExtra("weixin","wei2");
        PendingIntent weiP3 = PendingIntent.getBroadcast(context, MainActivity.requestCode++,  wei2, PendingIntent.FLAG_CANCEL_CURRENT);

       // zhi1.setData(Uri.parse("alipays://platformapi/startapp?appId=20000056"));



        views.setOnClickPendingIntent(R.id.zhi1, zhiP1);
        views.setOnClickPendingIntent(R.id.zhi2,  zhiP2);
        views.setOnClickPendingIntent(R.id.wei1,  weiP2 );
        views.setOnClickPendingIntent(R.id.wei2,   weiP3);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them



        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

