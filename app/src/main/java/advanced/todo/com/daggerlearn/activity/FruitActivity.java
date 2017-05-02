package advanced.todo.com.daggerlearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.R;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.BananaBean;
import advanced.todo.com.daggerlearn.bean.GreenTeaBean;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.component.DaggerFruitComponent;
import advanced.todo.com.daggerlearn.di.component.FruitComponent;
import advanced.todo.com.daggerlearn.di.qualifier.Type;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FruitActivity extends AppCompatActivity {

	@BindView(R.id.tv_fruit)
	TextView tvFruit;
	@BindView(R.id.toolBar)
	Toolbar mToolbar;

//	@Type("color")
//	@Inject
//	AppleBean appleColorA;
//	@Type("color")
//	@Inject
//	AppleBean appleColorB;


//	@Type("name")
//	@Inject
//	AppleBean appleNameA;
//
//	@Type("name")
//	@Inject
//	AppleBean appleNameB;

	@Inject
	OrangeBean orangeA;
	@Inject
	OrangeBean orangeB;

	@Inject
	BananaBean bananaA;
	@Inject
	BananaBean bananaB;

	@Inject
	GreenTeaBean greenTeaA;
	@Inject
	GreenTeaBean greenTeaB;

	@Inject
	AppleBean appleBeanA;
	@Inject
	AppleBean appleBeanB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		FruitComponent fruitComponent = DaggerFruitComponent.builder()
				.build();
		fruitComponent.inject(this);
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		ButterKnife.bind(this);

		initToolBar();

//		//  appleColorA:advanced.todo.com.daggerlearn.bean.AppleBean@3d061bc6
//		Log.d("test", "appleColorA:" + appleColorA.toString());
//		//  appleColorB:advanced.todo.com.daggerlearn.bean.AppleBean@19345787
//		Log.d("test", "appleColorB:" + appleColorB.toString());

		// Fruit - orangeA:advanced.todo.com.daggerlearn.bean.OrangeBean@3d061bc6
		Log.d("test", "Fruit - orangeA:" + orangeA.toString());
		// Fruit - orangeA:advanced.todo.com.daggerlearn.bean.OrangeBean@3d061bc6
		Log.d("test", "Fruit - orangeB:" + orangeB.toString());

		// Fruit - bananaA:advanced.todo.com.daggerlearn.bean.BananaBean@19345787
		Log.d("test", "Fruit - bananaA:" + bananaA.toString());
		// Fruit - bananaB:advanced.todo.com.daggerlearn.bean.BananaBean@275e96b4
		Log.d("test", "Fruit - bananaB:" + bananaB.toString());

		// Drink - greenTeaA:advanced.todo.com.daggerlearn.bean.GreenTeaBean@186932dd
		Log.d("test", "Fruit - greenTeaA:" + greenTeaA.toString());
		// Drink - greenTeaB:advanced.todo.com.daggerlearn.bean.GreenTeaBean@26382e52
		Log.d("test", "Fruit - greenTeaB:" + greenTeaB.toString());

		// Drink - greenTeaA:advanced.todo.com.daggerlearn.bean.GreenTeaBean@186932dd
		Log.d("test", "Fruit - appleBeanA:" + appleBeanA.toString());
		// Drink - greenTeaB:advanced.todo.com.daggerlearn.bean.GreenTeaBean@26382e52
		Log.d("test", "Fruit - appleBeanB:" + appleBeanB.toString());

		tvFruit.setText(orangeA.toString());
		tvFruit.append("\n");
		tvFruit.append(orangeB.toString());
		tvFruit.append("\n");
		tvFruit.append(bananaA.toString());
		tvFruit.append("\n");
		tvFruit.append(bananaB.toString());
		tvFruit.append("\n");
		tvFruit.append(greenTeaA.toString());
		tvFruit.append("\n");
		tvFruit.append(greenTeaB.toString());
		tvFruit.append("\n");
		tvFruit.append(appleBeanA.toString());
		tvFruit.append("\n");
		tvFruit.append(appleBeanB.toString());
	}

	protected int getLayoutId() {
		return R.layout.activity_fruit;
	}

	private void initToolBar() {

		mToolbar.setTitle("Fruit");
		mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
		mToolbar.setNavigationIcon(R.mipmap.ic_back);
		setSupportActionBar(mToolbar);

		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				killMySelf();
			}
		});
	}

	private void killMySelf() {
		finish();
	}
}
