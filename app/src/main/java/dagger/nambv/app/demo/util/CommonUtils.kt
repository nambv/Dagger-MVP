package dagger.nambv.app.demo.util

import android.app.Activity
import android.support.v7.app.AlertDialog
import android.widget.Toast

object CommonUtils {
    fun showDefaultAlert(activity: Activity, message: String) {
        val alertDialog = AlertDialog.Builder(activity).create()

        alertDialog.setTitle("Alert")
        alertDialog.setMessage(message)
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK"
                             ) { dialog, _ -> dialog.dismiss() }

        alertDialog.show()
    }

    fun showToastMessage(activity: Activity, message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}
