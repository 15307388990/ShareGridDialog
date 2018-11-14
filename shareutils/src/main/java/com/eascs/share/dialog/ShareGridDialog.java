package com.eascs.share.dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.eascs.share.adapter.ShareRecycleAdapter;
import com.eascs.share.impl.ShareGridDialogImpl;
import com.eascs.shareutils.R;
import com.eascs.shareutils.databinding.ShareNewBinding;


/**
 * @Author luoming
 * @Date 2018/11/6 11:56 AM
 */
public class ShareGridDialog extends DialogFragment implements ShareRecycleAdapter.OnItemClickListener, ShareGridEventHandler {
    private ShareNewBinding binding;
    private ShareRecycleAdapter mShareRecycleAdapter;
    private static final String PARAMS = "params";
    private ShareDialogParams mShareDialogParams;
    ShareGridDialogImpl dialogImpl;
    private int left, top, right, bottom;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }

    public void setDialogImpl(ShareGridDialogImpl dialogImpl) {
        this.dialogImpl = dialogImpl;
    }


    public static ShareGridDialog newInstance(ShareDialogParams shareDialogParams) {
        return newInstance(shareDialogParams, null);
    }

    public static ShareGridDialog newInstance(ShareDialogParams shareDialogParams, ShareIGridalogitemOnclik gridalogitemOnclik) {
        ShareGridDialog gridDialog = new ShareGridDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARAMS, shareDialogParams);
        gridDialog.setArguments(bundle);
        return gridDialog;
    }

    protected View headView, bottomView;


    public ShareGridDialog setHeadview(View headview) {
        this.headView = headview;
        return this;
    }

    public ShareGridDialog setBottomview(View bottomview) {
        this.bottomView = bottomview;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.share_new, container, (container != null));
        binding.setEventHandler(this);
        Bundle bundle = getArguments();
        mShareDialogParams = bundle.getParcelable(PARAMS);
        initAdapter();
        setAdapter();
        return binding.getRoot();
    }

    /**
     * 设置 listview 布局
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public void setMargins(int left, int top, int right, int bottom) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void initAdapter() {
        mShareRecycleAdapter = new ShareRecycleAdapter(getActivity(), this);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.DialogStyle_BottomAnimation);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.BOTTOM;
            window.setAttributes(params);
        }
    }

    public void showDialog(Activity activity) {
        showDialog(activity, "");

    }

    public void showDialog(Activity activity, String tag) {
        FragmentManager manager = activity.getFragmentManager();
        show(manager, tag);

    }

    public void setAdapter() {
        if (headView != null) {
            binding.moneyLayout.removeAllViews();
            binding.moneyLayout.addView(headView);
            binding.moneyLayout.setVisibility(View.VISIBLE);
        }

        binding.recylerView.setLayoutManager(new GridLayoutManager(getActivity(), mShareDialogParams.getSpanCount()));
        mShareRecycleAdapter.setList(mShareDialogParams.getShareItemVMS());
        binding.recylerView.setAdapter(mShareRecycleAdapter);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) binding.recylerView.getLayoutParams();
        layoutParams.setMargins(left, top, right, bottom);
        binding.recylerView.setLayoutParams(layoutParams);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.moneyLayout.removeAllViews();
    }

    /**
     * 取消
     */
    public void cancel() {
        dismiss();
    }


    @Override
    public void onItemClick(View view) {
        int position = binding.recylerView.getChildAdapterPosition(view);
        if (dialogImpl == null) {
            dialogImpl = new ShareGridDialogImpl(getActivity());
        }
        if (mShareDialogParams.getShareItemVMS().get(position).getTitle() == null) {
            return;
        }
        dialogImpl.onItemClick(view, position, mShareDialogParams.getShareItemVMS().get(position));
        dismiss();

    }


}
