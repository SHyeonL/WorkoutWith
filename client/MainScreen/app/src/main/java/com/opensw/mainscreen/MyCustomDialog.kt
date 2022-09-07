package com.opensw.mainscreen

import android.Manifest
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.opensw.mainscreen.databinding.FragmentMyProfileBinding
import com.opensw.mainscreen.mainscreen.MajorScreen
import java.io.File

class MyCustomDialog(context: Context) : Fragment() {

	var photoUri: Uri? = null

	lateinit var cameraPermission: ActivityResultLauncher<String>
	lateinit var storagePermission: ActivityResultLauncher<String>

	lateinit var cameraLauncher: ActivityResultLauncher<Uri>
	lateinit var galleryLauncher: ActivityResultLauncher<String>

	lateinit var binding : FragmentMyProfileBinding
	lateinit var majorScreen: MajorScreen
	private val dialog = Dialog(context)

	fun showDia() {
		dialog.setContentView(R.layout.custom_dialog)

		dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
		WindowManager.LayoutParams.WRAP_CONTENT)
		dialog.setCanceledOnTouchOutside(true)
		dialog.setCancelable(true)
		dialog.show()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		storagePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
			if(isGranted) {
				setViews()
			} else {
				Toast.makeText(majorScreen, "외부저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
				majorScreen.finish()
			}
		}

		cameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
			if(isGranted) {
				openCamera()
			} else {
				Toast.makeText(majorScreen, "카메라 권한을 승인해야 카메라를 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
			}
		}

		cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess  ->
			if(isSuccess) { binding.profileImage.setImageURI(photoUri) }
		}

		galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
			binding.profileImage.setImageURI(uri)
		}

		storagePermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
		return binding.root
	}

	fun setViews() {
		dialog.findViewById<Button>(R.id.btnCamera).setOnClickListener{
			cameraPermission.launch(Manifest.permission.CAMERA)
		}
		dialog.findViewById<Button>(R.id.btnGallery).setOnClickListener {
			openGallery()
		}
	}

	fun openCamera() {
		val photoFile = File.createTempFile(
			"IMG_",
			".jpg",
			majorScreen?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
		)

		photoUri = FileProvider.getUriForFile(
			majorScreen,
			"${majorScreen?.packageName}.provider",
			photoFile
		)

		cameraLauncher.launch(photoUri)
	}

	fun openGallery() {
		galleryLauncher.launch("image/*")
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		majorScreen = context as MajorScreen
	}
}