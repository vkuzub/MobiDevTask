package com.mobidevtask.ui.info_pokemon;


import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mobidevtask.R;
import com.mobidevtask.network.pojo.PokemonInfoResponse;
import com.mobidevtask.ui.base.fullinfo.BaseFullInfoFragment;
import com.mobidevtask.ui.base.fullinfo.BaseFullInfoPresenter;
import com.mobidevtask.ui.base.fullinfo.BaseFullInfoResponse;
import com.mobidevtask.utils.CollectionUtils;
import com.mobidevtask.utils.CommonDataExtractUtils;
import com.mobidevtask.utils.GlideCommon;

import butterknife.BindView;
import icepick.State;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoPokemonFragment extends BaseFullInfoFragment<InfoPokemonMVP.View> implements InfoPokemonMVP.View {

    public static final String FRAGMENT_TAG = "info_pokemon";
    @BindView(R.id.ivLogo)
    ImageView ivLogo;
    @BindView(R.id.pbMainImage)
    ProgressBar pbMainImage;
    @BindView(R.id.flAvatar)
    FrameLayout flAvatar;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvAbilities)
    TextView tvAbilities;
    @BindView(R.id.tvWeight)
    TextView tvWeight;

    @State
    PokemonInfoResponse response;

    public InfoPokemonFragment() {
        // Required empty public constructor
    }

    @Override
    public BaseFullInfoPresenter<InfoPokemonMVP.View> createPresenter() {
        return new InfoPokemonPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_info_pokemon;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (response != null) {
            fillData(response);
        }
    }

    @Override
    public void fillData(BaseFullInfoResponse response) {
        this.response = (PokemonInfoResponse) response;
        tvWeight.setText(String.valueOf(this.response.getWeight()));
        if (!CollectionUtils.isNullOrEmpty(this.response.getAbilities())) {
            tvAbilities.setText(String.valueOf(this.response.getAbilities().size()));
        } else {
            tvAbilities.setText(String.valueOf(0));
        }
        tvName.setText(CommonDataExtractUtils.getStringValue(this.response.getName()));

        GlideCommon.load(getActivity(), ivLogo, pbMainImage, this.response.getSprites(), false, null);
    }

    @Override
    public void initViews() {
        //do nothing
    }
}
