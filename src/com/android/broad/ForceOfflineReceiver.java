package com.android.broad;

import com.android.broadcastbestpractice.LoginActivity;
import com.android.collector.ActivityCollector;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {

	private Context _context;

	@Override
	public void onReceive(Context context, Intent intent) {

		this._context = context;
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("����!");
		alertDialog.setMessage("�û���ǿ�����ߣ������µ�½.");
		alertDialog.setCancelable(false);
		alertDialog.setPositiveButton("ȷ��",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						ActivityCollector.finshAll();
						Intent intent = new Intent(_context,
								LoginActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						_context.startActivity(intent);
					}
				});
		AlertDialog dialog = alertDialog.create();
		dialog.getWindow()
				.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		dialog.show();
	}
}
