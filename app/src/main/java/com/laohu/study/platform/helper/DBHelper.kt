package com.laohu.study.platform.helper

import android.content.Context
import com.laohu.study.platform.di.DatabasePath
import com.laohu.study.platform.extensions.orFalse
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

@ActivityScoped
class DBHelper @Inject constructor(
    @ApplicationContext private val context: Context,
    @DatabasePath private val databasePath: String
) {
    private val dbFile: File by lazy {
        File(databasePath)
    }

    suspend fun initializeDatabase() {
        if (dbFile.exists()) {
            delay(1000)
        } else {
            withContext(Dispatchers.IO) {
                if (!dbFile.parentFile?.exists().orFalse()) {
                    dbFile.parentFile?.mkdirs()
                }
                dbFile.createNewFile()
                copyDatabase()
            }
        }
    }

    private fun copyDatabase() {
        val inputStream: InputStream = context.assets.open("database/course.db")
        val outputStream: OutputStream = FileOutputStream(dbFile)
        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }
        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
}