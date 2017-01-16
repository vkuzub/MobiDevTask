package com.mobidevtask.utils;

import com.mobidevtask.App;
import com.mobidevtask.R;


public final class ErrorUtils {
    //// FIXME: 12.09.2016
    private ErrorUtils() {
    }
//
//    public static ErrorResponse parseError(Response<?> response) {
//        Converter<ResponseBody, ErrorResponse> converter = ServiceGenerator.getRetrofit()
//                .responseBodyConverter(ErrorResponse.class, new Annotation[0]);
//
//        ErrorResponse error;
//
//        ResponseBody errorBody = response.errorBody();
//        try {
//            error = converter.convert(errorBody);
//        } catch (IOException e) {
//            error = new ErrorResponse();
//            String unknown = App.getContext().getString(R.string.an_error_has_occurred);
//            ErrorResponse.Error rsp = new ErrorResponse.Error();
//            rsp.setMessage(unknown);
//            error.setError(rsp);
//        }
//        return error;
//    }
//
//    //
////    public static ErrorResponse.ErrorModelResponse parseModelError(ResponseInner<?> response) {
////        Converter<ResponseBody, ErrorResponse.ErrorModelResponse> converter = ServiceGenerator.getRetrofit()
////                .responseBodyConverter(ErrorResponse.ErrorModelResponse.class, new Annotation[0]);
////
////        ErrorResponse.ErrorModelResponse error;
////
////        ResponseBody errorBody = response.errorBody();
////        try {
////            error = converter.convert(errorBody);
////        } catch (IOException e) {
////            error = new ErrorResponse.ErrorModelResponse();
////            String unknown = App.getContext().getString(R.string.an_error_has_occurred);
////            error.setMessage(unknown);
////        }
////        return error;
////    }
////
//    public static String parseErrorToString(Response<?> response) {
//        ErrorResponse error = parseError(response);
//        ErrorResponse.Error rsp = error.getError();
//        if (rsp != null) {
//            return rsp.getMessage();
//        }
////        else {
////            err = App.getContext().getString(R.string.an_error_has_occurred);
////        }
//        return App.getApplication().getString(R.string.error_connecting_to_the_server_try_again_later);
//    }

    public static String getDefaultErrorMessage() {
        return App.getApplication().getString(R.string.oops_something_went_wrong);
    }

}
