package com.test.mad_project;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.Context.*;
import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, final int position, @NonNull model model)
    {
        holder.address.setText(model.getAddress());
        holder.age.setText(model.getAge());
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
      /*  holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.delete.getContext());
                builder.setTitle("Delete");
                builder.setMessage("you want to delete");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        FirebaseDatabase.getInstance().getReference().child("patients").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });*/

      /*  holder.copy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("PhoneNumber", holder.phone.getText());
                clipboard.setPrimaryClip(clip);

            }
        });*/

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child("patients").child(getRef(position).getKey()).removeValue();

            }
        });

        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
      return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView address,age,name,phone;
        Button delete;




        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            address=(TextView)itemView.findViewById(R.id.address);
            age=(TextView)itemView.findViewById(R.id.age);
            name=(TextView)itemView.findViewById(R.id.name);
            phone=(TextView)itemView.findViewById(R.id.phone);

            delete=(Button)itemView.findViewById(R.id.delete);



        }
    }

}
