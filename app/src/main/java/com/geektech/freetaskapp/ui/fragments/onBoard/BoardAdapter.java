package com.geektech.freetaskapp.ui.fragments.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.freetaskapp.R;
import com.geektech.freetaskapp.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private ItemBoardBinding binding;
    private final String[] titles = new String[]{"Добро пожаловать!", "О приложении:", "Удачного  пользования!"};
    private final String[] description = new String[]{"Захвати внимание пользователя используя односложные предложения с подлежащими и глаголами с самого начала!"
            , "Однако, для описания продукта нам не нужны абсолютно все функции. Достаточно выделить несколько основных, и одну самую важную.", ""};
    private final int[] lottie = new int[]{R.raw.lottie, R.raw.lottie2, R.raw.lottie3};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
        if (position == 2) {
            binding.boardBtn.setVisibility(View.VISIBLE);
        } else {
            binding.boardBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemBoardBinding itemView) {
            super(itemView.getRoot());
            binding.boardBtn.setOnClickListener(v -> {
                Navigation.findNavController(itemView.getRoot()).navigate(R.id.navigation_home);
            });
        }

        public void onBind(int position) {
            binding.itemBoardTv.setText(titles[position]);
            binding.itemBoardDes.setText(description[position]);
            binding.itemBoardIv.setAnimation(lottie[position]);
        }
    }
}
