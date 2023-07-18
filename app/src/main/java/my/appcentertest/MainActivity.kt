package my.appcentertest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import my.appcentertest.ui.theme.AppCenterTestTheme



class MainActivity : ComponentActivity() {
    val appCenterKeyName = "APP_CENTER_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appCenterKey = System.getProperty(appCenterKeyName) ?: System.getenv(appCenterKeyName)

        appCenterKey?.let {
            AppCenter.start(
                application,
                it,
                Analytics::class.java, Crashes::class.java
            )
            Log.i("App Center", "started")
        }

        setContent {
            AppCenterTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCenterTestTheme {
        Greeting("Android")
    }
}
