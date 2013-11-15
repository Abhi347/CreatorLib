package com.creator.creatorlib.manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Html;
import android.view.WindowManager;
import android.widget.TextView;

import com.creator.creatorlib.R;

public class CreatorMessenger {
	protected static CreatorMessenger mInstance = null;

	public static CreatorMessenger getInstance() {
		if (mInstance == null) {
			mInstance = new CreatorMessenger();
		}
		return mInstance;
	}

	protected Activity mActivity;

	protected Dialog mDialog;
	protected TextView textView;

	public void showMessage(Activity activity, String title, String msg) {
		mActivity = activity;
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setMessage(msg).setTitle(title);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// User clicked OK button
				dialog.dismiss();
			}
		});

		AlertDialog dialog = builder.create();

		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount = 0.0f;
		dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		dialog.show();

	}

	public void showMessage(Activity activity, String title, String msg,
			String buttonTitle) {
		mActivity = activity;
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setMessage(msg).setTitle(title);
		builder.setPositiveButton(buttonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// User clicked OK button
						dialog.dismiss();
					}
				});

		AlertDialog dialog = builder.create();

		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount = 0.0f;
		dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		dialog.show();

	}

	public void showProgressMessage(Activity activity, String msg) {
		mActivity = activity;
		/*
		 * try { if (mActivity.getClass() == BaseTabActivity.class) {
		 * BaseTabActivity baseActivity = (BaseTabActivity) mActivity;
		 * baseActivity.pauseLogoutTimer(); } } catch (ClassCastException ex) {
		 * ex.printStackTrace(); }
		 */
		mDialog = new Dialog(mActivity,
				android.R.style.Theme_Translucent_NoTitleBar);
		// mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mDialog.setContentView(R.layout.dialog_loading);

		textView = (TextView) mDialog.findViewById(R.id.textView);
		textView.setText(Html.fromHtml(msg));

		WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
		lp.dimAmount = 0.5f;
		mDialog.getWindow().setAttributes(lp);
		mDialog.getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		mDialog.setCancelable(false);
		mDialog.setCanceledOnTouchOutside(false);

		mDialog.show();

	}

	public void hideMessage() {
		if (mDialog != null)
			mDialog.dismiss();
	}

	public void hideProgressMessage() {

		/*
		 * try { if (mActivity.getClass() == BaseTabActivity.class) {
		 * BaseTabActivity baseActivity = (BaseTabActivity) mActivity;
		 * baseActivity.resumeLogoutTimer(); } } catch (ClassCastException ex) {
		 * ex.printStackTrace(); }
		 */

		if (mDialog != null)
			mDialog.dismiss();
	}

	public void showTwoButtonMessage(Activity activity, String title,
			String msg, DialogInterface.OnClickListener positiveListener,
			DialogInterface.OnClickListener negativeListener) {
		mActivity = activity;
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setMessage(msg).setTitle(title);
		builder.setPositiveButton("Ok", positiveListener);
		builder.setNegativeButton("Cancel", negativeListener);

		AlertDialog dialog = builder.create();

		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount = 0.0f;
		dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		dialog.show();

	}

	public void showOneButtonMessage(Activity activity, String title,
			String msg, String buttonTitle,
			DialogInterface.OnClickListener positiveListener) {
		mActivity = activity;
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setMessage(msg).setTitle(title);
		builder.setPositiveButton(buttonTitle, positiveListener);

		AlertDialog dialog = builder.create();

		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.dimAmount = 0.0f;
		dialog.getWindow().setAttributes(lp);
		dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

		dialog.show();

	}

}
