const loadProfile = (data) => {
    let wrapProfile = _$('#profile-js')
    let html = /*html*/ `<div class="col-sm-4 bg-c-lite-green user-profile">
        <div class="card-block text-center text-white">
          <div class="m-b-25">
            <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius"
                 alt="User-Profile-Image">
          </div>
          <h6 class="f-w-600">Chào</h6>
          <p>${data.fullname}</p>
          <i class="fa fa-edit" aria-hidden="true"></i>
        </div>
      </div>
      <div class="col-sm-8">
        <div class="card-block">
          <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
          <div class="row">
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">Họ và tên</p>
              <h6 class="text-muted f-w-400">${data.fullname}</h6>
            </div>
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">Username</p>
              <h6 class="text-muted f-w-400">${data.username}</h6>
            </div>
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">Email</p>
              <h6 class="text-muted f-w-400">${data.email}</h6>
            </div>
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">Gender</p>
              <h6 class="text-muted f-w-400">${data.gender? 'Nam' : 'Nữ'}</h6>
            </div>
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">Phone</p>
              <h6 class="text-muted f-w-400">${data.phone}</h6>
            </div>
          </div>
          <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Address</h6>
          <div class="row">
            <div class="col-sm-6">
              <p class="m-b-10 f-w-600">${data.address}</p>

            </div>

          </div>
          <ul class="social-link list-unstyled m-t-40 m-b-10">
            <li><a href="#!" data-toggle="tooltip" data-placement="bottom" title=""
                   data-original-title="facebook" data-abc="true"><i class="fab fa-facebook-f"></i></a></li>
            <li><a href="#!" data-toggle="tooltip" data-placement="bottom" title=""
                   data-original-title="twitter" data-abc="true"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
            <li><a href="#!" data-toggle="tooltip" data-placement="bottom" title=""
                   data-original-title="instagram" data-abc="true"><i class="fab fa-instagram" aria-hidden="true"></i></a></li>
          </ul>
        </div>
      </div>`
    wrapProfile.innerHTML = html
}

let userProfile = _$('.userProfile-js').innerHTML
http.get(`http://localhost:8080/Users/get/username/${userProfile}`)
    .then(data => loadProfile(data))
    .catch(err => console.log(err))