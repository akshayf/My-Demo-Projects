/**
 * Copyright 2016 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jhordan.people_mvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jhordan.people_mvvm.model.People;
import com.example.jhordan.people_mvvm.view.PeopleDetailActivity;


public class ItemPeopleViewModel extends BaseObservable {

  private People people;
  private Context context;

  public ItemPeopleViewModel(People people, Context context) {
    this.people = people;
    this.context = context;
  }

  public String getFullName() {
    people.fullName =
        people.name.title + "." + people.name.firts + " " + people.name.last;
    return people.fullName;
  }

  public String getCell() {
    return people.cell;
  }

  public String getMail() {
    return people.mail;
  }

  public String getPictureProfile() {
    return people.picture.medium;
  }

  @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url) {
    Glide.with(imageView.getContext()).load(url).into(imageView);
  }

  public void onItemClick(View view) {
    context.startActivity(PeopleDetailActivity.launchDetail(view.getContext(), people));
  }

  public void setPeople(People people) {
    this.people = people;
    notifyChange();
  }
}
