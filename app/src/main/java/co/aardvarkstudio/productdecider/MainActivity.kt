package co.aardvarkstudio.productdecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val productList = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decideBtn.isEnabled = false

        addItemBtn.setOnClickListener {
            val prod = Product()
            prod.name = productNameTxt.text.toString()
            prod.qualityRate = qualityBar.rating
            prod.priceRate = priceBar.rating

            productList.add(prod)

            productNameTxt.text.clear()
            decideBtn.isEnabled = true
        }

        decideBtn.setOnClickListener {
            var maxScore = 0.0f
            var maxIndex = 0
            for (i in 0..(productList.count()-1)){
                var auxScore = productList[i].qualityRate * productList[i].priceRate

                if(auxScore > maxScore){
                    maxScore = auxScore
                    maxIndex = i
                }
            }

            resultTxt.text = productList[maxIndex].name
        }
    }
}

class Product{
    var name = ""
    var priceRate = 0.0f
    var qualityRate = 0.0f

}
