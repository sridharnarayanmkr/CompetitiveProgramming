import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ManipulateTime {
    public static void  main(String[] args) throws ParseException {
        List<List<String>> list = new ArrayList<List<String>>();

        int testCase=0,channelCount=0;
        Scanner scan = new Scanner(System.in);
        testCase=scan.nextInt();
        for(int i=0;i<testCase;i++){
            channelCount=scan.nextInt();
            for(int j=0;j<channelCount;j++){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(scan.next());
                temp.add(scan.next());
                list.add(temp);
            }
        }
        Collections.sort(list, new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> o1, List<String> o2) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        format.setTimeZone(TimeZone.getTimeZone("UTC"));
                        try {
                            Date time1Start = format.parse(o1.get(0));
                            Date time1End = format.parse(o1.get(1));
                            Date time2Start = format.parse(o2.get(0));
                            Date time2End = format.parse(o2.get(1));
                            if((time1Start.getTime()-time2Start.getTime())<0){
                                return -1;
                            }else if((time1Start.getTime()-time2Start.getTime())>0){
                                return 1;
                            }else{
                                if((time1End.getTime()-time2End.getTime())<0){
                                    return 1;
                                }else if((time1End.getTime()-time2End.getTime())>0){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        return 0;
                    }
                });
        String playHours=findPlayHours(list);
        int count = findNext(list,0);
        System.out.println("Channel Count : "+count);
    }

    private static String findPlayHours(List<List<String>> list) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date totalHours=format.parse("00:00:00");
        for(int i=0;i<list.size();i++){
            Date start = format.parse(list.get(i).get(0));
            Date end = format.parse(list.get(i).get(1));
            if(i+1<list.size()){
                i++;
                Date newStart = format.parse(list.get(i).get(0));
                Date newEnd = format.parse(list.get(i).get(1));
                while((end.getTime()-newStart.getTime())>0 && (end.getTime()-newEnd.getTime())<0){
                    end=newEnd;i++;
                }
                long sum=start.getTime()+end.getTime()+totalHours.getTime();
//                totalHours= format.format(sum);
                System.out.println(format.format(sum));
            }else{
                continue;
            }
        }
        return " ";
    }

    private static int findNext(List<List<String>> list,int channel) throws ParseException {
        if(list.size()>0){
            channel++;
            String endTime=findMininum(list);
            while(endTime!=null){
                endTime=findNextChannel(list,endTime);

            }
            channel=findNext(list,channel);
        }
        else{
            return channel;
        }
        return channel;
    }

    private static String findNextChannel(List<List<String>> list, String endTime) throws ParseException {
        String value=null;
        int i=0;SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date end = format.parse(endTime);boolean flag=false;
        for(i=0;i<list.size();i++){
               Date start = format.parse(list.get(i).get(0));
               if((end.getTime()-start.getTime())<=0){
                   value=list.get(i).get(1);
                   flag=true;
                   break;
               }

        }
        if(flag==true){
            list.remove(i);
        }
        return value;
    }

    private static String findMininum(List<List<String>> list) {
        String endTime = list.get(0).get(1);
        list.remove(0);
        return endTime;
    }
}
