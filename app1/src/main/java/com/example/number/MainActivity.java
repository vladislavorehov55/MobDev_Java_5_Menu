package com.example.number;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    //int max_value = 100;
    int min_value = 1;
    int max_value = 5;
    int value_gen;
    Dialog dialog;
    TextView text;
    Boolean flag_game=true;
    Boolean flag_level = false;
    int level = 0;
    int counter = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Error");
        dialog.setContentView(R.layout.dialog_view);
        text = dialog.findViewById(R.id.dialogTextView);


    }

    public void onClick(View view) {
        counter += 1;
        if(flag_game == true && flag_level==true && !etInput.getText().toString().equals("")){

            if(level == 1){
                if(Integer.parseInt(etInput.getText().toString()) >= min_value && Integer.parseInt(etInput.getText().toString()) <= max_value ){
                    if (Integer.parseInt(etInput.getText().toString()) > value_gen){
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    }
                    else if(Integer.parseInt(etInput.getText().toString()) < value_gen){
                        tvInfo.setText(getResources().getString(R.string.behind));
                    }
                    else if (Integer.parseInt(etInput.getText().toString()) == value_gen){
                        tvInfo.setText(getResources().getString(R.string.hit));
                        value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
                    }
                }
                else if (Integer.parseInt(etInput.getText().toString())<min_value || Integer.parseInt(etInput.getText().toString())>max_value){
                    text.setText("Введенное число должно быть от " + Integer.toString(min_value) + "до " + Integer.toString(max_value));
                    dialog.show();
                }
            }
            else if(level == 2){
                if(counter<6 && tvInfo.getText()!=getResources().getString(R.string.hit)){
                    if(Integer.parseInt(etInput.getText().toString()) >= min_value && Integer.parseInt(etInput.getText().toString()) <= max_value){
                        if (Integer.parseInt(etInput.getText().toString()) > value_gen){
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        }
                        else if(Integer.parseInt(etInput.getText().toString()) < value_gen){
                            tvInfo.setText(getResources().getString(R.string.behind));
                        }
                        else if (Integer.parseInt(etInput.getText().toString()) == value_gen){
                            tvInfo.setText(getResources().getString(R.string.hit));
                            value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
                        }
                    }
                    else if (Integer.parseInt(etInput.getText().toString())<min_value || Integer.parseInt(etInput.getText().toString())>max_value){
                        text.setText("Введенное число должно быть от " + Integer.toString(min_value) + "до " + Integer.toString(max_value));
                        dialog.show();
                    }
                }
                else if(counter==6){
                    text.setText("Вы проиграли, так как исчерпали все попытки(5 штук).Игра начнется заново.");
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    etInput.setText("");
                    counter = 0;
                    dialog.show();
                    flag_game = true;
                }
                else if(tvInfo.getText()==getResources().getString(R.string.hit)){
                    text.setText("Вы выиграли. Игра начнется заново на этом же уровне сложности.");
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    etInput.setText("");
                    counter = 0;
                    dialog.show();
                    flag_game = true;
                }
            }
            else if(level == 3){
                if(counter<4 && tvInfo.getText()!=getResources().getString(R.string.hit)){
                    if(Integer.parseInt(etInput.getText().toString()) >= min_value && Integer.parseInt(etInput.getText().toString()) <= max_value){
                        if (Integer.parseInt(etInput.getText().toString()) > value_gen){
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        }
                        else if(Integer.parseInt(etInput.getText().toString()) < value_gen){
                            tvInfo.setText(getResources().getString(R.string.behind));
                        }
                        else if (Integer.parseInt(etInput.getText().toString()) == value_gen){
                            tvInfo.setText(getResources().getString(R.string.hit));
                            value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
                        }
                    }
                    else if (Integer.parseInt(etInput.getText().toString())<min_value || Integer.parseInt(etInput.getText().toString())>max_value){
                        text.setText("Введенное число должно быть от " + Integer.toString(min_value) + "до " + Integer.toString(max_value));
                        dialog.show();
                    }
                }
                else if(counter==4){
                    text.setText("Вы проиграли, так как исчерпали все попытки(3 штук).Игра начнется заново.");
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    etInput.setText("");
                    counter = 0;
                    dialog.show();
                    flag_game = true;
                }
                else if(tvInfo.getText()==getResources().getString(R.string.hit)){
                    text.setText("Вы выиграли. Игра начнется заново на этом же уровне сложности.");
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    etInput.setText("");
                    counter = 0;
                    dialog.show();
                    flag_game = true;
                }
            }
        }
        else if(flag_level==false && flag_game==true){
            counter = 0;
            text.setText("Выберите уровень сложности");
            dialog.show();
        }
        else if(etInput.getText().toString().equals("")){
            text.setText("Вы не ввели значение в поле ввода!");
            dialog.show();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_new_game){
            //bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
            flag_game=true;
            flag_level = false;
        }
        else if(item.getItemId()==R.id.level_1){
            flag_level = true;
            flag_game = true;
            level = 1;
            //bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
            text.setText("Это легкий уровень. У вас неограниченное количество попыток уадать число");
            dialog.show();
        }
        else if(item.getItemId()==R.id.level_2){
            flag_level = true;
            flag_game = true;
            level = 2;
            //bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
            text.setText("Это средний уровень сложности. У вас только 5 попыток, чтобы угадать число");
            dialog.show();
        }
        else if(item.getItemId()==R.id.level_3){
            flag_level = true;
            flag_game = true;
            level = 3;
            //bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
            text.setText("Это сложный уровень сложности. У вас только 3 попытки, чтобы угадать число");
            dialog.show();
        }
        else if(item.getItemId()== R.id.menu_exit){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        return super.onOptionsItemSelected(item);
    }
}

