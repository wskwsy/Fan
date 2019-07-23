package com.link.component_login.app.register

import android.os.Bundle
import android.text.Editable
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.link.component_login.R
import com.link.component_login.ViewModelFactory
import com.link.librarymodule.base.mvvm.view.BaseMvvmFragment
import com.link.librarymodule.utils.SimpleTextWatcher
import kotlinx.android.synthetic.main.login_fragment_register.*
import kotlinx.android.synthetic.main.login_fragment_register.clear_phone
import kotlinx.android.synthetic.main.login_fragment_register.et_password
import kotlinx.android.synthetic.main.login_fragment_register.et_phone
import kotlinx.android.synthetic.main.login_fragment_register.swich_pwd

/**
 * @author WJ
 * @date 2019-07-22
 *
 * 描述：注册
 */
class RegisterFragment(override var layoutId: Int = R.layout.login_fragment_register)
    : BaseMvvmFragment<RegisterViewModel>() {

    override fun getViewModel(): RegisterViewModel {
        return ViewModelFactory.getInstance().create(RegisterViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                RegisterFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

    override fun initView() {
        super.initView()
        val back = mRootView!!.findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }


        login.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        btn_sms.setOnClickListener {
            mViewModel.phone.value = et_phone.text.toString()
            mViewModel.requestSMSCode()
        }
        btn_confirm.setOnClickListener {
            mViewModel.phone.value = et_phone.text.toString()
            mViewModel.password.value = et_password.text.toString()
            mViewModel.code.value = et_code.text.toString()

            mViewModel.signUp()
        }

        //控制 清除按钮
        et_phone.addTextChangedListener(object : SimpleTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
                if (s.toString().isNotEmpty()) {
                    clear_phone.visibility = View.VISIBLE
                } else {
                    clear_phone.visibility = View.INVISIBLE
                }
            }

        })

        //清除手机号码
        clear_phone.setOnClickListener {
            mViewModel.clearPhone()
        }

        swich_pwd.setOnCheckedChangeListener { _, checked ->
            mViewModel.uc.pSwitchEvent.value = checked
        }

    }

    override fun initViewObservable() {
        super.initViewObservable()
        mViewModel.uc.pSwitchEvent.observe(this, Observer {
            if (!it) {
                et_password.transformationMethod = PasswordTransformationMethod.getInstance()
            } else {
                et_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
        })

        mViewModel.phone.observe(this, Observer {
            et_phone.setText(it)
        })
    }


}