import {AbstractControl} from '@angular/forms';

export class MatchPasswords{
   static matchPasswords(control: AbstractControl): { [key: string]: boolean } {
        if (
          control.get("user_password").value ===
          control.get("user_confirmPassword").value
        ) {
          return null;
        }
        return { passwordMatchError: true };
      }
}