package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class C_Recetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetacocteles)

        val buttonVolver = findViewById<ImageView>(R.id.Volver_recetascocteles)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }

        // Bellini
        findViewById<Button>(R.id.ButtonBellini).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Bellini")
            intent.putExtra("COCKTAIL_INGREDIENTS", "2 oz de zumo de durazno o melocotón\n2 oz de cava o champán\nZumo de arándanos o cereza")
            intent.putExtra("COCKTAIL_PREPARATION", "Prepara el zumo licuando los duraznos o melocotones. Puedes agregar hielo mientras licuas. Sirve en una copa de cava, agrega el zumo y luego el cava. Mezcla con una cucharilla larga hasta que todo se una. Para el tono rosa, agrega zumo de arándanos o cereza.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.bellini)
            startActivity(intent)
        }

        // Margarita
        findViewById<Button>(R.id.ButtonMargarita).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Margarita")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 ½ oz de tequila\n- 1 oz de triple sec\n- 1 oz de jugo de lima\n- Sal para el borde")
            intent.putExtra("COCKTAIL_PREPARATION", "Mezcla el tequila, el triple sec y el jugo de lima con hielo. Agita y sirve en un vaso con sal en el borde.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.margarita)
            startActivity(intent)
        }

        // Mojito
        findViewById<Button>(R.id.ButtonMojito).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Mojito")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de ron blanco\n- Jugo de medio limón\n- 2 cucharaditas de azúcar\n- Hojas de menta\n- Agua con gas")
            intent.putExtra("COCKTAIL_PREPARATION", "Machaca la menta con el azúcar y el limón. Agrega hielo, ron y agua con gas.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.mojito)
            startActivity(intent)
        }

        // Daiquiri
        findViewById<Button>(R.id.ButtonDaiquiri).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Daiquiri")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de ron blanco\n- 1 oz de jugo de lima\n- 1/2 oz de jarabe de azúcar")
            intent.putExtra("COCKTAIL_PREPARATION", "Mezcla el ron, el jugo de lima y el jarabe en una coctelera con hielo. Agita y cuela en una copa.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.daiquiri)
            startActivity(intent)
        }

        // Cosmopolitan
        findViewById<Button>(R.id.ButtonCosmopolitan).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Cosmopolitan")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 ½ oz de vodka\n- 1 oz de triple sec\n- 1/2 oz de jugo de lima\n- Un toque de jugo de arándano")
            intent.putExtra("COCKTAIL_PREPARATION", "Combina todos los ingredientes en una coctelera con hielo. Agita y cuela en una copa de cóctel.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.cosmopolitan)
            startActivity(intent)
        }

        // Martini
        findViewById<Button>(R.id.ButtonMartini).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Martini")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de ginebra o vodka\n- 1/2 oz de vermut seco")
            intent.putExtra("COCKTAIL_PREPARATION", "Revuelve el vermut y la ginebra o vodka con hielo. Cuela en una copa y decora con una aceituna o un twist de limón.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.martini)
            startActivity(intent)
        }

        // Piña Colada
        findViewById<Button>(R.id.ButtonPinaColada).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Piña Colada")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de ron\n- 1 oz de crema de coco\n- 3 oz de jugo de piña")
            intent.putExtra("COCKTAIL_PREPARATION", "Mezcla todos los ingredientes con hielo en una licuadora hasta que quede suave.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.pina_colada)
            startActivity(intent)
        }

        // Long Island
        findViewById<Button>(R.id.ButtonLongIsland).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Long Island")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1/2 oz de ron blanco\n- 1/2 oz de vodka\n- 1/2 oz de ginebra\n- 1/2 oz de tequila\n- 1/2 oz de triple sec\n- 1 oz de jugo de limón\n- Un toque de cola")
            intent.putExtra("COCKTAIL_PREPARATION", "Combina todos los licores y el jugo de limón en un vaso alto con hielo. Agrega un toque de cola.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.long_island)
            startActivity(intent)
        }

        // Negroni
        findViewById<Button>(R.id.ButtonNegroni).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Negroni")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 oz de ginebra\n- 1 oz de vermut rojo\n- 1 oz de Campari")
            intent.putExtra("COCKTAIL_PREPARATION", "Revuelve los ingredientes con hielo y cuela en un vaso bajo. Decora con una rodaja de naranja.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.negroni)
            startActivity(intent)
        }

        // Gintonic
        findViewById<Button>(R.id.ButtonGintonic).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Gintonic")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de ginebra\n- Agua tónica\n- Rodaja de limón\n- Hielo")
            intent.putExtra("COCKTAIL_PREPARATION", "Sirve la ginebra sobre hielo en un vaso alto, agrega agua tónica y decora con una rodaja de limón.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.gintonic)
            startActivity(intent)
        }

        // Caipirinha
        findViewById<Button>(R.id.ButtonCaipirinha).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Caipirinha")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de cachaça\n- 1 lima\n- 2 cucharaditas de azúcar\n- Hielo")
            intent.putExtra("COCKTAIL_PREPARATION", "Machaca la lima con el azúcar, agrega cachaça y hielo, y mezcla bien.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.caipirinha)
            startActivity(intent)
        }

        // Manhattan
        findViewById<Button>(R.id.ButtonManhattan).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Manhattan")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 2 oz de whisky\n- 1 oz de vermut rojo\n- Unas gotas de angostura")
            intent.putExtra("COCKTAIL_PREPARATION", "Revuelve el whisky, vermut y angostura con hielo, cuela en una copa y decora con una cereza.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.manhattan)
            startActivity(intent)
        }

        // Sex on the Beach
        findViewById<Button>(R.id.ButtonSexOnTheBeach).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Sex on the Beach")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 ½ oz de vodka\n- 1 oz de licor de durazno\n- 2 oz de jugo de naranja\n- 2 oz de jugo de arándano")
            intent.putExtra("COCKTAIL_PREPARATION", "Combina todos los ingredientes en un vaso alto con hielo y revuelve.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.sex_on_the_beach)
            startActivity(intent)
        }

        // Mai Tai
        findViewById<Button>(R.id.ButtonMaiTai).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Mai Tai")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 oz de ron blanco\n- 1 oz de ron oscuro\n- ½ oz de triple sec\n- ½ oz de jugo de lima\n- ½ oz de jarabe de almendra")
            intent.putExtra("COCKTAIL_PREPARATION", "Combina los ingredientes en un vaso con hielo, agita y decora con una rodaja de lima y una cereza.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.mai_tai)
            startActivity(intent)
        }


        // Coco Loco
        findViewById<Button>(R.id.ButtonCocoLoco).setOnClickListener {
            val intent = Intent(this, CocktailDetailActivity::class.java)
            intent.putExtra("COCKTAIL_NAME", "Coco Loco")
            intent.putExtra("COCKTAIL_INGREDIENTS", "- 1 oz de ron blanco\n- 1 oz de tequila\n- 1 oz de vodka\n- Agua de coco\n- Jugo de lima")
            intent.putExtra("COCKTAIL_PREPARATION", "Mezcla todos los ingredientes en un coco fresco o vaso grande con hielo.")
            intent.putExtra("COCKTAIL_IMAGE", R.drawable.coco_loco)
            startActivity(intent)
        }

    }
}
