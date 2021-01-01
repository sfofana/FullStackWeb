import { formatDate } from '@angular/common';
export class Logger {

  public static info(message: string) {
    const format = 'MM/dd/yyyy, hh:mm:ss a';
    const locale = 'en-US';
    let date = new Date();
    console.log(`${formatDate(date, format, locale)} - ${message}`)
  }
}
