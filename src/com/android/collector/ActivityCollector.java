package com.android.collector;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {

	public static List<Activity> activitys = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		if (!activitys.contains(activity)) {
			activitys.add(activity);
		}
	}

	public static void removeActivity(Activity activity) {
		if (activitys.contains(activity)) {
			activitys.remove(activity);
		}
	}

	public static void finshAll() {
		for (Activity activity : activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
}
