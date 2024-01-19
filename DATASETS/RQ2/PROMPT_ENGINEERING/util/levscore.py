import pandas as pd
from Levenshtein import ratio, distance
import re




merge_df = pd.read_csv('RAW_DATA.csv')
merge_df = merge_df.dropna( subset=['ChatGPT implementation (version 1)','ChatGPT implementation (version 2)'])
v1_lev_dists = []
v1_cos_dists = []

for index, row in merge_df.iterrows():
    #distance(row['ChatGPT implementation (version 1)'], row['ChatGPT implementation (version 2)'])
    try:
        #cosine.cosine(row['ChatGPT implementation (version 1)'], row['ChatGPT implementation (version 2)'])
        v1 = re.sub(' +', ' ', row['ChatGPT implementation (version 1)'])
        v2 = re.sub(' +', ' ', row['ChatGPT implementation (version 2)'])
        print(ratio(v1, v2))
        print(distance(row['ChatGPT implementation (version 1)'],row['ChatGPT implementation (version 2)']))
        print("=====================================")
        v1_lev_dists.append(ratio(v1, v2))
    except:
        print(row['Exercise ID'])
    
    #v1_cos_dists.append(cosine.cosine(row['ChatGPT implementation (version 1)'], row['ChatGPT implementation (version 2)']))
merge_df['distance'] = v1_lev_dists

merge_df.to_csv('metrics_ratio_dist.csv', index=False)

