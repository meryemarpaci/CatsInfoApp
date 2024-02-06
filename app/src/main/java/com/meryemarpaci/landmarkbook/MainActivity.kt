package com.meryemarpaci.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.meryemarpaci.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var van:String
    private lateinit var tekir:String
    private lateinit var brit:String
    private lateinit var sarman:String
    private lateinit var scot:String
    private lateinit var sfenks:String
    private lateinit var catList : ArrayList<cats>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        catList=ArrayList<cats>()

        van = "Bir göz renginin diğerinden farklı olması ile ün salan Van kedisi bembeyaz tüyleri ve yumuşak gövdesi ile görenleri kendisine hayran bırakan türden bir kedidir. Oldukça esnek bir iskelet yapısına sahip olan Van kedisi çok narindir ve bakışları fazlasıyla yumuşaktır. Oldukça oyuncu ve fazlasıyla meraklı da bir karakteri vardır"
        sarman="Tekir kedi türleri arasında bir alt sınıf olan sarman kedileri kendisini sevdirmeye bayılır. En dost canlısı varlıklardan biridir. İnsanlara ve sahiplerine yakınlık göstermekten hoşlanırlar. Yaşadıkları alana ve mekana karşı aidiyetlik duygusu hissederler."
        tekir ="Bulundukları ortamı hızlı bir şekilde benimserler ve hızlı öğrenmeye yeteneklidirler. Çok meraklı ve hareketli oldukları için pencereden ya da balkondan düşebilirler. Bu yüzden Tekir kedi sahiplerinin bu konuda önlem almaları gerekir. Çok küçük yerlere girebilirler, dolayısıyla hiç beklenmedik yerlerden çıkabilirler."
        brit = "Zeki bir kedi olan British Shorthair, yaramazlık yapmaz ve tek başına kaldığında da uslu olmaya devam eder. İlk bakışta tembel gibi görünse de aslında hareketli ve oyun oynamayı seven bir kedidir. Fakat diğer kedi cinslerinin aksine, öylesine koşturup etrafı dağıtmaz. Sahibiyle oyun oynar ve ona uyum sağlar."
        scot ="İskoç kırması bu tatlı kediler, İskoçya’daki çiftlik kedilerinin kendiliğinden bir mutasyon sonucu ortaya çıkmış bir cinstir. En belirgin özellikleri kulaklarının katlı olmasıdır. Bu özelliğiyle farklı ve dayanıklı bir görünüme sahip olan Scottish Fold’lar aynı zamanda arkadaş canlısı ve yüksek zekâ seviyesine sahip türde birer cins kedidirler."
        sfenks="Kedi türleri arasında tüysüz olan tek kedi cinsi Mısır kedisi Sfenks kedisi. Sahiplerine oldukça bağlı olan ve fazlasıyla yakınlık gösteren Sfenks kedileri ilk olarak Kanada ve civarında ortaya çıkmışlardır. Bu nedenle onlara Kanada Sfenks’i de denilebilmektedir. Adını Yunan mitolojisinden alan bu tüysüz kedi cinsi büyük gözler ve ince bir kuyruğa sahiptir. Görünümleri açısından çoğu kişi tarafından korkutucu görünseler de oldukça sıcakkanlı ve sahiplerine düşkün birer kedidirler."

        //Data
        val vanCat = cats("Van Kedisi",van,R.drawable.vankedisi)
        val tekirCat=cats("Tekir",tekir,R.drawable.tekir)
        val britCat=cats("British Shorthair",brit,R.drawable.britishshorthair)
        val sarmanCat=cats("Sarman",sarman,R.drawable.sarman)
        val scotCat=cats("Scottish Fold",scot,R.drawable.scottishfold)
        val sfenksCat=cats("Sfenks",sfenks,R.drawable.sfenks)


        catList.add(vanCat)
        catList.add(tekirCat)
        catList.add(britCat)
        catList.add(sarmanCat)
        catList.add(scotCat)
        catList.add(sfenksCat)

        //Adapter: Layout & Data
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,catList.map { cats -> cats.name })

        binding.listview.adapter = adapter
        binding.listview.onItemClickListener=AdapterView.OnItemClickListener{parent,view,position,id ->
            val intent=Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("cats",catList.get(position))
            startActivity(intent)
        }
    }
}