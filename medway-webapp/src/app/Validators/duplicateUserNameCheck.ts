import { UserService } from '../services/user.service';
import { AsyncValidatorFn, AbstractControl } from '@angular/forms';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { UserModel } from '../models/userModel';
import Swal from 'sweetalert2/dist/sweetalert2.js'

export class DuplicateUserNameCheck {
  static checkUserName(_serviceObj: UserService): AsyncValidatorFn {
      return (control: AbstractControl): Observable<{ [key: string]: boolean } | null> => {

      if (control.value != null && control.value != '') {
          return _serviceObj.getAllUsers().pipe(

          map((res: UserModel[]) => {
            if (res.length != 0) {

              let matched: boolean = false;
              for (let index = 0; index < res.length; index++) {
                  if (res[index].user_name == control.value) {
                  matched = true;
                  break;
                }
              }

              if (matched) {
                return { 'duplicateUserName': true };
              } else {
                  return null;
              }

            } else {
                return null;
            }

          })
        );
      }

      return of(null);
    };
  }

}
