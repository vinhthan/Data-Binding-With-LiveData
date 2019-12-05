package com.example.databindingwithlivedata

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    @Bindable
    val editTextContent = MutableLiveData<String>()

    //Update LiveData

    //sau khi bam btn thi hien thi gtri cua edt
    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = _displayedEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayedEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value = FakeRepository.getRandomFruitName()
    }

    //thay doi tung gtri cua TextView
    //hien thi ngay lap tuc tung gtri cua edt vao txv khi dc go tu ban phim
    private val _changeEdittext = MutableLiveData<String>()
    val changeEditText: LiveData<String>
        get() = _changeEdittext

}

//LiveData con co them:
//Transformations.map()
//Transformations.switchMap()

